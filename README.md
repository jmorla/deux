# Deux Programming Language

Deux is an experimental programming language designed to explore innovative language features

## Build & Execution

```sh
$  ant package
```

sample.de
```js
return 10 abcd; //invalid token abcd 
```

```sh
$ java -jar ./build/deuxc.jar docs/sample.dx

# output
sample.de:2:11  Error 'abcd' unrecognized symbol
   2 | return 64 abcd;
     |           ^
```

## Compilation Goal

The goal is to compile the following statement
```js
return 64;
```

to this equivalent assembly nasm code
```asm
global _start

_start:
    mov rax, 60
    mov rdi, 64
    syscall
```