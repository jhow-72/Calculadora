# Calculadora
Implementação Java do case "Calculadora" para vaga de Engenharia de Software JR do Itau Unibanco

Você precisa corrigir os seguintes problemas no codigo:

1. Aplicação só está processando o primeiro item da fila infinitamente.
    - Corrigido, estava sendo chamado metodo que apenas retornava o proximo valor da fila
    - Trocar para o metodo "pop()" ou para "Dequeu()" no c# resolveu

2. Implemente a funcionalidade de divisão.
    - Concluída
    - Foi aplicado o padrão strategy para as operações, com a finalidade de melhorar a legibilidade e manutenibilidade

3. Aplicação não está calculando a penultima operação corretamente.
    - O valor passado como parametro "2147483647" é o valor mais alto que um int consegue guardar
    - Trocar para um long ou um BigInteger e realizar as operações com esses tipos resolveu

Saída esperada no console:

```
14 - 8 = 6

5 * 6 = 30

2147483647 + 2 = 2147483649

18 / 3 = 6
```

4. Implemente uma funcionalidade para imprimir toda a lista de operações a ser processada após cada calculo realizado.
    - Concluída

5. Crie uma nova pilha (Stack) para guardar o resultado de cada calculo efetuado e imprima a pilha ao final
    - Concluída

Não existe resposta certa ou errada, o objetivo do case é avaliar a linha de raciocínio de cada candidato. Você é livre para fazer na linguagem de sua preferência, desde que aplique as mesmas funcionalidades e tarefas deste case. Dica: Utilize Visual Code ou Visual Studio Community para realizar as tarefas.

-> desafio concluído e pronto para ser apresentado