JAVAC=javac
ANTLR=java -jar /usr/local/lib/antlr-3.5.2-complete.jar

sources = $(wildcard while_language/parsing/*.java) $(wildcard while_language/ast/*.java)  $(wildcard while_language/*.java) \
while_language/parsing/WhileLanguageLexer.java \
while_language/parsing/WhileLanguageParser.java

classes = $(sources:.java=.class)

all: 	while_language/parsing/WhileLanguageLexer.java $(classes)

clean :
	rm -f *.class

%.class : %.java
	$(JAVAC) $<


while_language/parsing/WhileLanguageLexer.java: while_language/parsing/WhileLanguage.g
	$(ANTLR) while_language/parsing/WhileLanguage.g
