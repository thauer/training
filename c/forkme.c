#include <sys/types.h> /* pid_t */
#include <sys/wait.h>  /* waitpid */
#include <stdio.h>     /* printf, perror */
#include <stdlib.h>    /* exit */
#include <unistd.h>    /* _exit, fork */
#include <sys/stat.h>
#include <fcntl.h>
 
#define PERMS (S_IRUSR | S_IWUSR | S_IRGRP | S_IWGRP | S_IROTH | S_IWOTH)
int main() {  
  int fd1, fd2;

  printf("%d\n", S_IRUSR);
  printf("%d\n", S_IWUSR);
  printf("%d\n", S_IXUSR);
  printf("%d\n", S_IRGRP);
  printf("%d\n", S_IWGRP);
  printf("%d\n", S_IXGRP);
  printf("%d\n", S_IROTH);
  printf("%d\n", S_IWOTH);
  printf("%d\n", S_IXOTH);
  umask(0); 54
  fd1 = open("file1", O_CREAT | O_RDWR, PERMS);
  umask(S_IRGRP | S_IWGRP | S_IROTH | S_IWOTH);
  fd2 = open("file2", O_CREAT | O_RDWR, PERMS);
  return 0;
}