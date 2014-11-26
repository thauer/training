#include "cliserv.h"

int main() {
  struct sockaddr_in serv, cli;
  char request[REQUEST];
  char reply[REPLY] = "My reply\n";
  int sockfd, n, clilen;

  if((sockfd = socket(PF_INET, SOCK_DGRAM, 0)) < 0)
    err_sys("socket error");

  memset(&serv, 0, sizeof(serv));

  serv.sin_family = AF_INET;
  serv.sin_addr.s_addr = htonl(INADDR_ANY); // Anywhere
  serv.sin_port = htons(UDP_SERV_PORT);     // 7777

  if(bind(sockfd, (SA) &serv, sizeof(serv)) < 0)
    err_sys("bind error");

  for(;;) {
    clilen = sizeof(cli);
    if((n=recvfrom(sockfd, request, REQUEST, 0, (SA) &cli, &clilen)) < 0)
      err_sys("recvfrom error");

    printf("%s", request);

    if(sendto(sockfd, reply, REPLY, 0, (SA) &cli, sizeof(cli)) != REPLY)
      err_sys("sendto error");
  }
}