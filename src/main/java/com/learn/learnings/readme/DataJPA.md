# Spring Data JPA:

##### Why to use @Enumerated(EnumType.STRING)

Basically if your @Entity has any Enum field you want to map that field to varchar field use above annotation


##### @MappedSuperClass

@MappedSuperClass should be added on Parent class while 
inheritance in hibernate and JPA. 
So when new table gets created parent class fields will be added automatically.
