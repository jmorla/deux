package org.deuxc.compiler;

/**
 * This class represents an assembly mnemonic, which is the symbolic name of an
 * instruction in assembly language.
 * It provides a means to encapsulate and work with assembly mnemonics.
 */
public interface AsmMemonic {

    /**
     * 8-bytes Registers
     * 
    */
    String RAX = "rax";
    String RBX = "rbx";
    String RCX = "rcx";
    String RDX = "rdx";
    String RDI = "rdi";
    String RSI = "rsi";
    String RBP = "rbp";
    String RSP = "rsp";

    /**
     * Data movement
    */
    String MOV = "mov";

    /**
     * syscall
    */
    String SYSCALL = "syscall";

    String SEPARATOR = ", ";

}
