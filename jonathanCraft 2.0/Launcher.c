#include <stdlib.h>

int main() {
	// system("cd res/worlds");
	// system("wget https://raw.githubusercontent.com/yonatanmx/JonathanCraft/main/jonathanCraft%202.0/leveler.txt");
	system("cd -");
	system("javac Launcher.java");
	system("java Launcher");
	system("rm *.class");
}