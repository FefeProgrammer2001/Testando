use std::io;

fn busca_sequencial(vetor: &[char], tamanho: usize, valor: char) -> Option<usize> {
    for i in 0..tamanho {
        if vetor[i] == valor {
            return Some(i);
        }
    }
    None
}

fn main() {
    let mut tamanho = String::new();
    println!("Type the array size: ");
    io::stdin().read_line(&mut tamanho).unwrap();
    let tamanho: usize = tamanho.trim().parse().unwrap();
    let mut vetor = Vec::with_capacity(tamanho);
    println!("Type the array chacarters:");
    for j in 0..tamanho {
        println!("Character {}: ", j + 1);
        let mut input = String::new();
        io::stdin().read_line(&mut input).unwrap();
        vetor.push(input.trim().chars().next().unwrap());
    }
    let mut valor = String::new();
    println!("Type a character to find: ");
    io::stdin().read_line(&mut valor).unwrap();
    let valor: char = valor.trim().chars().next().unwrap();
    let teste = busca_sequencial(&vetor, tamanho, valor);
    if teste.is_none() {
        println!("The character wasn't found");
    } else {
        println!("The character was found on the index {}", teste.unwrap());
    }
}
