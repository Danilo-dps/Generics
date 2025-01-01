# Generics
- Quando há a parametrização, usando o `<T>`, isso permite que que seja definido um comportamento genérico de tipo, que terá 
sua especialização no momento de instanciação
- `Generics` permitem que `classes`, `interfaces` e `métodos` possam ser
parametrizados por tipo. Seus benefícios são:
- Reuso
- Type safety
- Performance
- Uso comum: coleções

# Genéricos Delimitados
## Calculation Service
- Nesse exemplo de uso, a `classe Product` implementa a `interface Comparable`
- O `método max` está parametrizado para aceitar qualquer tipo de objeto `genérico <T>` que implemente a `interface Comparable<T>`. 
- A assinatura do `método <T extends Comparable<T>>` impõe essa restrição, garantindo que qualquer tipo `<T>` passado para o método deve implementar `Comparable<T>`.
- Assim, o método pode chamar `compareTo` nos elementos da lista, porque ele sabe que todos os elementos são comparáveis entre si. 
- Isso permite que o método funcione corretamente para encontrar o maior elemento em uma lista de qualquer tipo que implemente Comparable.
- Basicamente, a parametrização `<T extends Comparable<T>>` assegura que o tipo `<T>` é um subtipo de `Comparable<T>`, o que significa que `T` deve implementar a interface `Comparable` para ser aceito pelo método `max`. 
- Quando se chama o`método estático max` com uma lista de `Product`, o parâmetro de tipo genérico `<T>` é substituído por `Product`. Portanto, a assinatura do método `max` basicamente se torna:
`public static Product max(List<Product> list)`
- Assim, quando é feito a chamada:
`Product x = CalculationService.max(list);`
- O compilador Java entende que `<T>` é `Product`, e o método `max` retorna um objeto do tipo `Product`, que é então atribuído à variável x.
- Toda a parametrização genérica `<T extends Comparable<T>>` assegura que o método `max` pode ser utilizado com qualquer tipo que implemente `Comparable<T>`, e nesse exemplo específico, `Product` é esse tipo. Isso permite que o método seja flexível e reutilizável para diferentes tipos, desde que esses tipos implementem a interface `Comparable`.