#include "cliserv.h"

void err_quit(const char *x, ...) {
  printf("%s\n", x);
  exit(0);
}

void err_sys(const char *x, ...) {
  printf("%s\n", x);
}

int read_stream(int x, char *s, int m) {
  return 0;
}