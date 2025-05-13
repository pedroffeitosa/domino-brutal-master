# Dominó Brutal

Um campeonato de dominós para robôs, desenvolvido como exercício de LP2 (Programação Orientada a Objetos em Java) na Computação@UFCG.

## 📋 Sobre o Projeto

Dominó Brutal é um projeto educacional que implementa um jogo de dominó onde os jogadores são controlados por diferentes estratégias (robôs). O objetivo é permitir que estudantes pratiquem conceitos de Programação Orientada a Objetos através da implementação de estratégias de jogo.

## 🎮 Como Jogar

1. Clone o repositório
2. Compile o projeto usando seu IDE Java preferido ou via linha de comando
3. Execute a classe `DominoBrutal` para jogar uma partida única
4. Execute a classe `DominoBrutalRepetido` para analisar o desempenho de diferentes estratégias

## 🏗️ Arquitetura do Projeto

### Componentes Principais

- `Jogo.java`: Gerencia o fluxo do jogo e as regras
- `Jogador.java`: Representa um jogador com sua estratégia e peças
- `Mesa.java`: Gerencia o tabuleiro onde as peças são colocadas
- `Peca.java`: Representa uma peça de dominó
- `Jogada.java`: Representa uma jogada no jogo

### Sistema de Estratégias

O projeto utiliza um sistema de estratégias implementado através da interface `EstrategiaDeJogo`. Cada estratégia define como um jogador deve tomar suas decisões durante o jogo.

## 🧪 Testes

O projeto inclui uma suíte de testes abrangente. Para entender o design do projeto, comece analisando os testes de unidade, especialmente `JogoTest.java`.

## 🎯 Criando uma Nova Estratégia

Para criar uma nova estratégia:

1. Implemente a interface `EstrategiaDeJogo`
2. Defina sua lógica de decisão no método `decideJogada`
3. Teste sua estratégia contra as existentes usando `DominoBrutalRepetido`

## 📚 Conceitos de POO Demonstrados

- Encapsulamento
- Herança
- Polimorfismo
- Interfaces
- Exceções
- Coleções Java

## 🎨 Curiosidade

O nome "Dominó Brutal" é uma referência ao desenho Irmão do Jorel, onde várias coisas têm o adjetivo "brutal" em homenagem a Steve Magal. Nenhum jogador ou animal é ferido em nenhuma partida! Veja exemplos [aqui](https://irmaodojorel.fandom.com/pt-br/wiki/Recreio_Brutal) e [aqui](https://irmaodojorel.fandom.com/pt-br/wiki/A_Perigosa_Lambada_Brutal).

## 🤝 Contribuindo

Contribuições são bem-vindas! Sinta-se à vontade para:
- Implementar novas estratégias
- Melhorar a documentação
- Adicionar novos testes
- Reportar bugs

## 📝 Licença

Este projeto está sob a licença incluída no arquivo LICENSE.
