package br.com.sulimann.decorator;

import java.util.Map;

public record Request(
  String ip,
  Map<String, String> headers
)  {

}
