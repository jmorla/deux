# Deux Programming Language

Deux is an experimental programming language designed to explore innovative language features

## Build & Execution

```sh
$  ant package
```

```sh
$ java -jar ./build/deuxc.jar "return 0;"

# output
Token(RETURN)
Number(0)
Token(SEMICOLON)
Token(EOF)
```

```sh
$ java -jar ./build/deuxc.jar "foo return noob 0; bar"

# output
Token(ERROR)
Token(RETURN)
Token(ERROR)
Number(0)
Token(SEMICOLON)
Token(ERROR)
Token(EOF)
```
