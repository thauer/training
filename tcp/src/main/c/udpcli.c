#include "cliserv.h"

int main(int argc, char *argv[]) {

  struct sockaddr_in serv;
  char request[REQUEST] = "My request\n", reply[REPLY];
  int sockfd, n;

  if(argc != 2)
    err_quit("usage: udpcli <IP address of server>");

  if((sockfd = socket(PF_INET, SOCK_DGRAM, 0)) < 0)
    err_sys("socket error");

  memset(&serv, 0, sizeof(serv));
  serv.sin_family = AF_INET;
  serv.sin_addr.s_addr = inet_addr(argv[1]);
  serv.sin_port = htons(UDP_SERV_PORT);

  if(sendto(sockfd, request, REQUEST, 0, (SA) &serv, sizeof(serv)) != REQUEST)
    err_sys("sendto error");
  if((n = recvfrom(sockfd, reply, REPLY, 0, (SA) NULL, (int *) NULL)) < 0)
    err_sys("recvfrom error");
  printf("%s", reply);

  exit(0);
}