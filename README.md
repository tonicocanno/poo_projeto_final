# poo_projeto_final - API RESTful

API RESTful que permite gerenciar reservas de veículos e seus clientes.

## Developed by
 - Antonio Canno
 - Matheus Jacob - https://github.com/Matheus-jacobb

### Requisitos da aplicação:

1. Gerenciar Veículos-CRUD
    - Código
    - Modelo
    - Valor diária.
 

1. Gerenciar Cliente-CRUD
    - Código
    - Nome
    - Endereço
    - CPF
    
### Roadmap:

- [X] Cadastro de conta com Google
- [X] Tem um número.
- [X] Cliente deverá existir.
- [X] Veículo deverá existir.
- [X] O total da reserva deverá ser calculado.
- [X] Um veículo pode ser reservado várias vezes, porém somente em períodos/datas diferentes.
- [X] Data de Início (Deverá ser maior que a data do sistema). Não pode começar no Domingo.
- [X] Data de Fim (Deverá ser maior que a data de Início). Não existe entrega no Domingo.
- [X] Tem um número.
- [X] Cliente deverá existir.
- [X] Veículo deverá existir.
- [X] O total da reserva deverá ser calculado.
- [X] Um veículo pode ser reservado várias vezes, porém somente em períodos/datas diferentes.
- [X] Data de Início (Deverá ser maior que a data do sistema). Não pode começar no Domingo.
- [X] Data de Fim (Deverá ser maior que a data de Início). Não existe entrega no Domingo.
- [X] O caminho para criar uma reserva é: POST de clientes/{id-cliente}/veiculos/{id-veiculo}
- [X] Listar uma reserva pelo número.
- [X] Listar as reservas de um cliente.
- [X] Listar as reservas de um veículo.
- [X] Apagar reserva ao apagar veículo.
- [X] Deploy no Heroku
- [X] Apagar reserva ao apagar cliente/veiculo.
- [X] Omitir cliente no mapeamento "cliente/{idCliente}/reservas"
- [X] Omitir veiculo no mapeamento "veiculo/{idVeiculo}/reservas"