/////////////////////////////////////////////
// compilation: c++ -o pgcd pgcd.cc
// execution: ./pgcd
/////////////////////////////////////////////

/*Voici le contenu d'un commentaire int x = 5 + y;*/

#include <iostream>
#include <string>
using namespace std;

int main(int argn, char **argv){
  int a;
  int b;
  std::cout << "Entrer a: ";
  std::cin >> a;
  std::cout << "Entrer b: ";
  std::cin >> b;

  /* Commentaire int x = 42; */
  while(true){
    if (b > a){
      b = b % a;
      if (b==0) break;
    }
    else{
      a = a % b;
      if (a == 0) break;
    }
  }
  std::cout << "pgcd: ";
  if (a == 0)
    std::cout << b << std::endl;
  else
    std::cout << a << std::endl;

  int x = 42;
  float y = 3.14;
  float xy = 3/4;
  float _x1z = -450E12;

  float test = -12-3;
  float test2 = -12e-3;

  bool expr = (x % 2 == 0) | (3 & 4);
  std::string myString = "This is a string \n\t int x = 3;";
  std::string emptyString = "";

  /*/**//**//**//*/*//////////////*/*/*/*/*/*/*/*/****////*/*/*/*/*/*/**/
  // Commentaire

  bool expr2 = (x % 2 == 0) ? true : false;
}
