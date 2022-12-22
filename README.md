
# Trabalho Prático 1 - Test-Driven Development

UnB - Universidade de Brasilia

FGA - Faculdade do Gama

TPPE - Técnicas de Programação para Plataformas Emergentes

## Participantes

|Matrícula | Aluno |
| -- | -- |
| 19/0054832  |  Arthur Talles de Sousa Cunha |
| 19/0042419  | Davi Matheus da Rocha de Oliveira  |
| 19/0045485  |  Eduardo Gurgel Pereira de Carvalho  |
| 19/0058650  | Natanael Fernandes Coelho Filho  |

## Dependências

A elaboração desse projeto foi feita usando Java + Apache Maven, sendo o segundo responsável por gerenciar dependencias do projeto(junit entre outros), os quais estavam respectivamente em suas versões, 17 e 3.6.3.

A equipe faz uso de linux, no geral distribuições que usam o Ubuntu de base, então segue alguns passos para instalação:

```shell
# instalação do java
apt install openjdk-17-jdk openjdk-17-jre

# instalação do maven
apt install maven
```

## Para rodar o projeto

```shell
# clone o repositório
git clone https://github.com/TecProgFGA/TDD.git

# Vá até o diretório onde se encontra a pasta src/ e o arquivo pom.xml
cd TDD/calculadoraIRPF/irpf/

# execute os testes 
mvn test
```
