## @Basic annotation

기본 유형은 javax.persistence.Basic 어노테이션으로 표시된다.
일반적으로 @Basic 어노테이션은 기본적으로 가정 되므로 생략할 수 있다.

### 명시적으로 선언
```java
@Entity(name = "Product")
public class Product {
	@Id
	@Basic
	private Integer id;
	@Basic
	private String sku;
	@Basic
	private String name;
	@Basic
	private String description;
}
```
### @Basic를 암시적으로 선언
```java
@Entity(name = "Product")
public class Product {
	@Id
	private Integer id;
	private String sku;
	private String name;
	private String description;
}
```

* optional - boolean: null을 허용하는 지 여부
* fetch - FetchType(기본적으로 EAGER) 값을 가져오는 지에 대한 여부

## @Column

## Enum

### @Enumerated

* ORDINAL: 열거값의 서수 위치에 따라 저장
* STRING: 이름에 따라 저장

## @Formula

```java
@Entity(name = "Account")
public static class Account {
	@Id
	private Long id;
	private Double credit;
	private Double rate;
	@Formula(value = "credit * rate")
	private Double interest;
}
```

## @MappedSuperclass
```java
@MappedSuperclass
public static class Account {
	@Id
	private Long id;
	private String owner;
	private BigDecimal balance;
	private BigDecimal interestRate;
}

@Entity(name = "DebitAccount")
public static class DebitAccount extends Account {
	private BigDecimal overdraftFee;
}

@Entity(name = "CreditAccount")
public static class CreditAccount extends Account {
	private BigDecimal creditLimit;
}
```
```sql
CREATE TABLE DebitAccount (
    id BIGINT NOT NULL ,
    balance NUMERIC(19, 2) ,
    interestRate NUMERIC(19, 2) ,
    owner VARCHAR(255) ,
    overdraftFee NUMERIC(19, 2) ,
    PRIMARY KEY ( id )
)

CREATE TABLE CreditAccount (
    id BIGINT NOT NULL ,
    balance NUMERIC(19, 2) ,
    interestRate NUMERIC(19, 2) ,
    owner VARCHAR(255) ,
    creditLimit NUMERIC(19, 2) ,
    PRIMARY KEY ( id )
)
```

## single table
```java
@Entity(name = "Account")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public static class Account {
	@Id
	private Long id;
	private String owner;
	private BigDecimal balance;
	private BigDecimal interestRate;
}

@Entity(name = "DebitAccount")
public static class DebitAccount extends Account {
	private BigDecimal overdraftFee;
}

@Entity(name = "CreditAccount")
public static class CreditAccount extends Account {
	private BigDecimal creditLimit;
}
```
```sql
CREATE TABLE Account (
    DTYPE VARCHAR(31) NOT NULL ,
    id BIGINT NOT NULL ,
    balance NUMERIC(19, 2) ,
    interestRate NUMERIC(19, 2) ,
    owner VARCHAR(255) ,
    overdraftFee NUMERIC(19, 2) ,
    creditLimit NUMERIC(19, 2) ,
    PRIMARY KEY ( id )
)
```