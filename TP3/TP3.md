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

## Boa documentação

### Descrição:
A documentação de um produto de software deve ser, resumidamente falando, uma descrição precisa deste determinado sistema, abordando desde a elicitação de requisitos e a arquitetura definida para o projeto até o código-fonte por ele utilizado.

Uma boa documentação serve como um ponto de apoio e sustentação do projeto durante a evolução do software. As etapas de desenvolvimento, compreensão e manutenção de código são direta e positivamente influenciadas se tiverem uma boa documentação como base.

Além de sua contribuição direta à equipe de desenvolvimento, a documentação, quando bem elaborada e executada, se torna uma ferramenta que propicia maior facilidade, por parte de usuários e quem mais tiver interesse no sistema, em conhecer mais sobre dado software e seus processos relacionados. 

### Relação com maus cheiros: 
- Comentários: a utilização deste tipo de documentação de código proporciona aos desenvolvedores um diagnóstico mais preciso dos maus-cheiros presentes no sistema, em partes específicas ou como um todo. Os comentários têm como objetivo propiciar mais simplicidade e maior legibilidade para o projeto. Contudo, são também ferramentas e indícios de alguns eventuais problemas presentes no código. Alguns deles, os quais podemos destacar, são:  
    
    * Métodos Longos: uma eventual necessidade de adicionar comentários a trechos específicos de um método pode ser um indício de que este se mostra longo e necessita, portanto, de refatoração. 
    * Código Duplicado: a utilização de comentários ao longo do código-fonte pode ser uma ferramenta interessante para evidenciar ocorrências repetitivas de um mesmo trecho de código e, desta forma, facilitar a identificação por parte dos desenvolvedores.  
    * Longa Lista de Parâmetros: uma eventual necessidade de comentar uma lista de parâmetros, tendo em vista o comprometimento de sua legibilidade devido ao tamanho, pode também ser um importante indicativo de que aquele trecho possui mau-cheiro e deve, portanto, ser refatorado. 

- Mudanças divergentes: dada a mudança de comportamento de determinadas funcionalidades e classes em decorrência de uma também mudança nas regras de negócio, faz-se necessário que tais mudanças sejam documentadas e resultem, portanto, na refatoração desta característica (boa documentação) associada ao software atual.

### Operação de refatoração:
Durante a evolução de um determinado software, é imprescindível que também haja atualizações em relação à documentação do mesmo. A ideia é justamente que a documentação seja um espelho para o comportamento do software. Desta forma, diagramas, esquemas e desenhos não devem ser estáticos, eles devem abstrair as mudanças das regras de negócio e espelhar nos documentos criados.

Existem também operações de refatoração que estão indiretamente associadas à uma boa documentação. Tendo em vista a importância da documentação do código, por meio de comentários, para a identificação de maus-cheiros, esta atividade abre margem para alguns processos de refatoração. São eles:

#### Métodos Longos
* Extrair método: sempre que necessário diminuir o tamanho de um método. 
* Substituir método por método-objeto: quando mesmo aplicando as combinações acima a assinatura do método ainda possui muitos parâmetros.
* Decompor condicional: sempre que lidar com expressões condicionais e loops.
#### Código Duplicado
* Extrair método: quando a mesma expressão encontra-se em dois métodos na mesma classe. 
* Extrair método / puxar para cima: quando a mesma expressão está em classes irmãs. 
* Extrair método / método template: extrair comportamento comum de dois métodos e implementar a variabilidade em subclasses.
* Substituir algoritmo: em casos de substituir algoritmo por um mais claro.
#### Longa Lista de Parâmetros
* Preservar o objeto inteiro: para substituir um conjunto de dados vindos de um objeto e substituí-los pelo próprio objeto. 
* Introduzir objeto-parâmetro: para substituir um conjunto de dados que não estão logicamente relacionados por um objeto de dados.
