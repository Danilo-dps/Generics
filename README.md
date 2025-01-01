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

# Tipos Curinga (Wildcard Types) em Java

### Super Tipo vs Subtipo
- **Super Tipo**: Um tipo que é ancestral de outros tipos. Em Java, `Object` é o supertipo de todas as outras classes.
- **Subtipo**: Um tipo que herda de outro tipo, sendo uma versão mais específica. Por exemplo, `String` é um subtipo de `Object`.
### Classe Object
- A `classe Object` é o supertipo de todas as classes em Java. Isso significa que qualquer objeto de qualquer classe pode ser tratado como um `Object`.
- Exemplo: `Object obj = new String("Hello");` é válido porque `String` é um subtipo de `Object`.
### List<Object> não é supertipo de outras List<>
- Embora `Object` seja o supertipo de todas as classes, `List<Object>` não é o supertipo de todas as listas. Cada instância genérica de `List<>` é independente.
- Por exemplo, você não pode passar `List<String>` onde `List<Object>` é esperado.
### Tipos Curinga (Wildcard Types)
- **Tipos Curinga (Wildcard Types)** permitem maior flexibilidade nos métodos. Eles permitem que um método aceite parâmetros de diferentes tipos sem especificar explicitamente o tipo em tempo de compilação.
- Uma `List<?>` pode conter qualquer tipo, mas dentro do método, o tipo dos elementos é tratado como `Object`.
- Exemplo:
  ```java
	public static void printList(List<?> list) {
		for (Object obj : list) {
			System.out.println(obj);
		}
	}
- Esse método `printList` pode aceitar uma `List<Integer>`, `List<String>`, ou qualquer outra lista.
- `List<?> como Super Tipo`: ao usar List<?>, você cria um método capaz de aceitar qualquer tipo de lista, oferecendo uma solução flexível e poderosa para manipulação de coleções heterogêneas.

### Restrição 
- **Tipos Curinga (Wildcard Types)** não permitem adicionar dados a uma coleção de tipo curinga

# Curingas delimitados(bounded wildcards)

- A ideia geral da delimitação é garantir o type safety dos dados, assim como nos genéricos delimitados, os curingas delimitados tem essa proposta

# Generics & Wildcards

- `Wildcards` são um complemento dos `Generics`
- Enquanto os generics permitem a criação de classes, interfaces e métodos genéricos
- Os wildcards permitem que que métodos definidos como genéricos, recebam qualquer tipo de dado ligado com a estrutura da classe ou interface da qual ele faz parte.

# Princípio get/put - covariância
- Quando é permitido acessar o dado(get), mas não é possivel adicionar dado(put)
```java
List<Integer> intList = new ArrayList<Integer>();
intList.add(10);
intList.add(5);
List<? extends Number> list = intList;
Number x = list.get(0);
list.add(20); // erro de compilacao
get - OK
put - ERROR
```
	
# Princípio get/put - contravariância
- Quando é permitido adicionar dado(put), mas não é possivel acessar o dado(get)
```java
List<Object> myObjs = new ArrayList<Object>();
myObjs.add("Maria");
myObjs.add("Alex");
List<? super Number> myNums = myObjs;
myNums.add(10);
myNums.add(3.14);
Number x = myNums.get(0); // erro de compilacao
get - ERROR
put - OK
```