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
