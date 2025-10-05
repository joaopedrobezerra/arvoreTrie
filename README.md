n# Implementação de Árvore Trie - Estruturas de Dados Multiway

## 📋 Informações do Trabalho

**Disciplina:** Resolução de Problemas Estruturados em Computação (Turma 4º U)  
**Curso:** Ciência da Computação (Noite) - PUCPR  
**Professor:** Andrey Cabral  
**Data de Entrega:** 05/10  
**Grupo:**  João Pedro Bezerra e Gabriel Zem Muraro 

## 🌳 Por que Escolhemos a Árvore Trie?

### Razões da Escolha:

1. **Simplicidade de Implementação**: A Trie é uma estrutura relativamente simples de implementar e entender, permitindo que todos os membros do grupo compreendam completamente o funcionamento.

2. **Aplicações Práticas Relevantes**: A Trie é amplamente utilizada em:
   - Sistemas de autocompletar (como Google, IDEs)
   - Corretores ortográficos
   - Sistemas de busca e indexação
   - Roteamento de redes
   - Compressão de dados

3. **Eficiência em Operações de String**: A Trie oferece complexidade O(m) para busca, inserção e remoção, onde m é o comprimento da string, sendo muito eficiente para operações com strings.

4. **Facilidade de Demonstração**: As operações da Trie são visualmente intuitivas e fáceis de demonstrar em vídeo, facilitando a explicação para a audiência.

5. **Versatilidade**: Permite implementar funcionalidades avançadas como busca por prefixo e sugestões, tornando o projeto mais interessante e completo.

## 🎯 Estrutura do Projeto

```
tde/
├── src/
│   ├── Main.java                    # Classe principal 
│   └── trie/                        # Pacote das classes
│       ├── TrieNode.java           # Nó da estrutura 
│       ├── SimpleStringList.java   # Lista dinâmica 
│       └── TriePure.java           # Implementação 
└── README.md                       # Documentação
```

## 🚀 Como Executar

### Pré-requisitos:
- Java 8 ou superior
- Terminal/Command Prompt

### Compilação e Execução:
```bash
# Compilar o projeto
javac -d . src/trie/*.java src/Main.java

# Executar o programa
java Main
```

### Saída Esperada:
```
search(casa): true
search(cachorro): true
search(cafeteria): false
startsWith(ca): true
startsWith(cb): false
Sugestões para 'ca':
 - cachorro
 - caminho
 - cantar
 - casa
```

**Desenvolvido para a disciplina de Resolução de Problemas Estruturados em Computação - PUCPR**
