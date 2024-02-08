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
$ java -jar ./build/deuxc.jar docs/sample.de

# output
sample.de:2:11  Error 'abcd' illegal symbol
   2 | return 10 abcd;                         
     |            ^ 
```

## Compilation Goal

The goal is based on this source
```js
return 64;
```

Generate this equivalent assambly nasm code
```asm
global _start

_start:
    mov rax, 60 # setting sysexit
    mov rdi, 64 # parameter
    syscall # making the syscall
```