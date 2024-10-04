const net = require('net');

const porta = 8080;
const ip = '192.168.0.100'; // Substitua pelo IP do computador que está rodando o servidor

const client = new net.Socket();

client.connect(porta, ip, () => {
  console.log('Conectado ao servidor');

  const readline = require('readline');
  const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
  });

  rl.question('Digite um comando (enviar, listar, deletar): ', (comando) => {
    switch (comando) {
      case 'enviar':
        rl.question('Digite o nome do arquivo a enviar: ', (arquivo) => {
          rl.question('O arquivo já existe? (sim/não): ', (existe) => {
            if (existe.toLowerCase() === 'sim') {
              rl.question('Digite o nome do arquivo existente: ', (nomeArquivoExistente) => {
                client.write(`enviar ${arquivo} existente ${nomeArquivoExistente}`);
              });
            } else {
              rl.question('Digite o conteúdo do arquivo: ', (conteudo) => {
                client.write(`enviar ${arquivo} ${conteudo}`);
              });
            }
          });
        });
        break;

      case 'listar':
        client.write('listar');
        break;

      case 'deletar':
        rl.question('Digite o nome do arquivo a deletar: ', (arquivoDeletar) => {
          client.write(`deletar ${arquivoDeletar}`);
        });
        break;

      default:
        console.log('Comando inválido');
        break;
    }
  });

  client.on('data', (data) => {
    console.log(data.toString());
  });

  client.on('end', () => {
    console.log('Desconectado do servidor');
  });
});
