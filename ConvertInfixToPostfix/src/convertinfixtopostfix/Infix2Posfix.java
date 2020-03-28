/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package convertinfixtopostfix;

import java.util.Stack;

/**
 *
 * @author CBui
 */
public class Infix2Posfix {

    public static void main(String[] args) {
         int number = evaluateExpression("444+55-12/3+1");
         System.out.println(number);
    }

    private static int evaluateExpression(String expression) {
        //create operand Stack to store operands
        Stack<Integer> operandStack = new Stack<>();

        //create operator stack to store operators
        Stack<Character> operatorStack = new Stack<>();

        //Inser blank around (,),+,-,/, and *
        expression = insertBlank(expression);

        //Extract operand and operators
        String[] tokens = expression.split(" ");

        //Phase 1: scan tokens
        for (String token : tokens) {
            if (token.length() == 0) //blank space
            {
                continue; //back to while loop to extract the nex token
            } else if (token.charAt(0) == '+' || token.charAt(0) == '-') {
                // Process All + , -, * , / in the top of the operator stack
                while (!operatorStack.isEmpty()
                        && (operatorStack.peek() == '+'
                        || operatorStack.peek() == '-'
                        || operatorStack.peek() == '*'
                        || operatorStack.peek() == '/')) {
                    processAndOperator(operandStack, operatorStack);
                }
                //push the + or - operator into the operator stack
                operatorStack.push(token.charAt(0));
            } else if (token.charAt(0) == '*' || token.charAt(0) == '/') {
                // Process all * , / in the top of the operator stack
                while (!operatorStack.isEmpty()
                        && (operatorStack.peek() == '*')
                        || operatorStack.peek() == '/') {
                    processAndOperator(operandStack, operatorStack);
                }

                // Push the * or / operator into the operator stack
                operatorStack.push(token.charAt(0));
            } else if (token.trim().charAt(0) == '(') {
                operatorStack.push('('); //Push '(' to stack
            } else if (token.trim().charAt(0) == ')') {
                // Process all the operators in the stack until seeing '('
                while (operatorStack.peek() != '(') {
                    processAndOperator(operandStack, operatorStack);
                }

                operatorStack.pop(); // Pop the '(' symbol from the stack
            } else {
                // An operand scanned , push an operand to the stack
                operandStack.push(new Integer(token));
            }
        }
        //Phase 2: process all the remaining operators in the stack
        while (!operatorStack.isEmpty()) {
            processAndOperator(operandStack, operatorStack);
        }
        //Return the result
        return operandStack.pop();
    }

    private static void processAndOperator(Stack<Integer> operandStack, Stack<Character> operatorStack) {
        char op = operatorStack.pop();
        int op1 = operandStack.pop();
        int op2 = operandStack.pop();

        if (op == '+') {
            operandStack.push(op2 + op1);
        } else if (op == '-') {
            operandStack.push(op2 - op1);
        } else if (op == '*') {
            operandStack.push(op2 * op1);
        } else if (op == '/') {
            operandStack.push(op2 / op1);
        }
    }

    private static String insertBlank(String s) {
        String result = "";
        for (int i =0; i< s.length(); i ++){
            if(s.charAt(i) =='(' || s.charAt(i) == ')' ||
                    s.charAt(i) =='+' || s.charAt(i) =='-'||
                    s.charAt(i)=='*'|| s.charAt(i)=='/'){
                result += " " + s.charAt(i) + " ";
            } else {
                result += s.charAt(i);
            }
        }
        return result;
    }
}
