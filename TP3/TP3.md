# Trabalho Prático 3

## Ausência de duplicidade

### Descrição
O código duplicado pode apresentar repetições excessívas de trechos de código semelhantes que podem resultar até em perda de desempenho. Isso também é um problema para o entendimento da aplicação, além de prejudicar a manutenção do código.

### Relação com mau cheiro
Código duplicado: O mesmo trecho de código aparecer em vários pontos do projeto.

Exemplo:
```
public int calculaSoma(List<Integer> numbers) {
    int sum = 0;
    for (int num : numbers) {
        sum += num;
    }
    return sum;
}

public int calculaProduto(List<Integer> numbers) {
    int product = 1;
    for (int num : numbers) {
        product *= num;
    }
    return product;
}
```
### Operação de refatoração
Operações aplicáveis (sugestões):
- Extrair método: quando a mesma expressão encontra-se em dois métodos na mesma classe. 
- Extrair método / puxar para cima: quando a mesma expressão está em classes irmãs. 
- Extrair método / método template: extrair comportamento comum de dois métodos e implementar a variabilidade em subclasses.

Exemplo:

```
public int calcula(List<Integer> numeros, int inicial, Operacao operacao) {
    int result = inicial;
    for (int num : numeros) {
        result = operation.apply(result, num);
    }
    return result;
}

public int calculaSoma(List<Integer> numero) {
    return calcula(numero, 0, (a, b) -> a + b);
}

public int calculaProduto(List<Integer> numero) {
    return calcula(numero, 1, (a, b) -> a * b);
}

```


## Simplicidade

### Descrição
Quando se trata de software, ter um código simples significa que ele é acessível para ser lido, compreendido e alterado com facilidade. A simplicidade tem como principal fator a facilidade de uso para os seres humanos. Ao seguir esta característica, a estrutura do código torna-se mais clara e objetiva, aumentando sua claridade e coesão.

### Relação com mau cheiro
- Código duplicado: O mesmo trecho de código aparecer em vários pontos do - projeto.
- Método longo: Quanto maior for o  método, mais difícil é de entendê-lo. Vários métodos curtos (e a delegação entre eles) é preferível.
- Classe grande: Quando uma classe apresenta muitas variáveis de instâncias é indício de que ela está com coesão baixa (fazendo mais do que deveria).


### Operação de refatoração

- Extrair método: quando a mesma expressão encontra-se em dois métodos na mesma classe. 

- Renomear variável: Operação que transforma o nome da variável, simplificar e fácil de entender.

## Idiomático

### Descrição 
Os idiomas estão intimamente relacionados à clareza e à coesão do seu código. Isso porque a leitura do código deve ser como ler uma história, você deve entender as convenções de nomenclatura e expressões idiomáticas. Alguns idiomas têm convenções de nomenclatura comuns. Seguir esses métodos de design permite que outros programadores entendam imediatamente a estrutura do código, reduzindo a curva de aprendizado e os erros.

### Relação com mau cheiro

Ao contrário de outros recursos, o idiomático não tem uma relação forte com o mau cheiro que Fowler apresentou, mas não fazer o código idiomático pode levar a pontos de refatoração. Por exemplo:
-  Código duplicado: Onde o código pode pode aparecer várias vezes de maneiras diferentes no projeto.
-  Métodos longos: No qual dependendo da diferença de linguagem são difíceis de entender.

### Operação de refatoração

Nesses casos, pode-se usar as operações de refatoração:
- extrair objeto 
- substituir método por método-objeto 
- Entre outros, dependendo  muito do caso utilizado.