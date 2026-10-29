# Sudoku em Java Swing

Aplicação gráfica de estudo que apresenta uma grade de Sudoku e verifica números em linhas, colunas e blocos 3×3. A interface foi construída com Swing e AWT, bibliotecas da plataforma Java.

## Recursos implementados

- Janela com grade de 9×9 campos.
- Células preenchidas inicialmente exibidas em cinza e bloqueadas para edição.
- Botão **Verificar** com mensagem de resultado.
- Validação de valores de 1 a 9, números repetidos e entradas não numéricas.

## Como executar

Requer um JDK e um ambiente com interface gráfica. Na raiz do repositório:

```sh
git clone https://github.com/JoaoAlencar00/sudoku.git
cd sudoku
mkdir build
javac -encoding UTF-8 -d build src/SudokuGUI.java
java -cp build SudokuGUI
```

A classe `SudokuGUI` contém a interface, o tabuleiro inicial, a validação e o ponto de entrada.

## Estado atual do tabuleiro

A matriz `board` publicada contém uma solução completa, sem células vazias. Por isso, todas as posições abrem bloqueadas e o botão verifica um tabuleiro já resolvido.

O código permite edição nas posições cujo valor inicial seja `0`. Para experimentar essa interação, altere manualmente algumas posições de `board` para `0` antes de compilar.

## Escopo atual

Projeto desktop educacional, sem API HTTP ou dependências externas. Não há geração de desafios, seleção de dificuldade, cronômetro, salvamento de partidas ou testes automatizados no repositório.
