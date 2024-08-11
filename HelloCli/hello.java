///usr/bin/env jbang "$0" "$@" ; exit $?
//DEPS info.picocli:picocli:4.6.3

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.Callable;
import java.net.URI;
import java.util.stream.Stream;
import java.util.stream.Collectors;

@Command(name = "hello", mixinStandardHelpOptions = true, version = "hello 0.1", description = "hello made with jbang")
class hello implements Callable<Integer> {

  @Parameters(index = "0", description = "The greeting to print", defaultValue = "World!")
  private String arg;

  public static void main(String... args) {
    int exitCode = new CommandLine(new hello()).execute(args);
    System.exit(exitCode);
  }

  @Override
  public Integer call() throws Exception { // your business logic goes here...
    System.out.println(arg);
    if (arg == null) {
      arg = "https://www.yahoo.com";
    }
    URI uri = URI.create(arg);
    HttpClient client = HttpClient.newHttpClient();
    HttpRequest request = HttpRequest.newBuilder(uri).build();
    HttpResponse<Stream<String>> response = client.send(request, HttpResponse.BodyHandlers.ofLines());
    String lines;
    try (Stream<String> body = response.body()) {
      lines = body
          .filter(line -> line.contains("php"))
          .collect(Collectors.joining("\n"));
    }
    System.out.println(lines);
    return 0;
  }
}
