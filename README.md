
API Backend - Monitor de Preços
Esta API em Java é responsável por gerenciar os produtos, controlar as regras de negócio e servir como ponto de comunicação entre o banco de dados e o frontend.

O que este código faz
Gerenciamento: Cadastro e listagem de produtos para monitoramento.

Coordenação: Integração com o script de raspagem em Python para atualização de preços.

Persistência: Conexão com banco de dados MySQL para manter o histórico de preços.

Interface: Fornece os endpoints REST para o frontend consumir os dados.

Tecnologias
Linguagem: Java 17+

Framework: Spring Boot, Spring Data JPA

Banco de Dados: MySQL 8.0

Como rodar
Configuração do Banco: Certifique-se de que o MySQL esteja rodando e crie o schema do banco.

Configuração da API: Ajuste as credenciais de acesso ao banco no arquivo application.properties.

Execução: Rode o projeto através do Spring Tools ou terminal na porta 8080.

Integração: Esta API espera que o script Python esteja disponível no sistema para ser chamado durante as rotinas de atualização de preços.

Endpoints Principais
GET /itens: Lista todos os produtos cadastrados.

POST /itens: Registra um novo item para monitoramento (requer JSON com os dados do produto).
