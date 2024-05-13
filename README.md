# Transacoes

Transacoes é uma plataforma financeira que permite a transferência de dinheiro fictício entre usuários, listando tudo em
histórico.
Este é seu back-end, responsável pela regra de negócio da plataforma web.

O projeto foi gerado utilizando Java 17.

## Servidor de desenvolvimento

Para rodar o projeto, é preciso selecionar qual SDK será utilizada.

### IntelliJ

`Menu>Project Structure>SDK>Download SDK>Amazon 17.0.9`

Após selecionar a SDK, abra o arquivo TransacoesApplication e rode sua função main.

O ambiente fica disponível em: `http://localhost:8080/`

As rotas disponíveis são:

`/operation/{scheduledTransferDate}` para recuperar taxa do dia
`/operation/all` para recuperar todas as operações agendadas
`/operation/transfer` para realizar a transferência

## Testes
Atualmente existem duas contas registradas no projeto: 1122334455 e 1122334456.


Nenhum teste unitário foi alterado.
