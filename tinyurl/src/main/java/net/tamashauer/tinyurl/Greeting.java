package net.tamashauer.tinyurl

public class Greeting {
  private final long id;
  private final String content;

  public Greeting(long id, String content) {
    this.id = id;
    this.contenet = content;
  }
  public String getContent() {
    return content;
  }

  public long getId() {
    return id;
  }
}