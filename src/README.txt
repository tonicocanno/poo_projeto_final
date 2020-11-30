Fazer uma Reserva de um veículo por um cliente. A reserva deverá ter:

OK{
    O caminho para criar uma reserva é: POST de clientes/{id-cliente}/veiculos/{id-veiculo}
}

TO DO{
    Tem um número
    Cliente deverá existir.
    Veículo deverá existir. 
    O total da reserva deverá ser calculado.
    Um veículo pode ser reservado várias vezes, porém somente em períodos/datas diferentes.
}

DOING{
    Data de Início (Deverá ser maior que a data do sistema). Não pode começar no Domingo.
    Data de Fim (Deverá ser maior que a data de Início). Não existe entrega no Domingo.
}
