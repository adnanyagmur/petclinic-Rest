# petclinic-Rest

Pet Clinic veteriner uygulaması hayvan sahiplerinin ve hayvan sahiplerinin hayvaların kayıt altına alınması sağlamak için geliştirilmiştir. Uygulama içerisinde önce hayvan sahinin kaydı ve bu hayvan sahinin sahip olduğu hayvanların kaydı gerçekleştirilebilmektedir. Sistem üserinden ilgili hayvan ya da hayvan sahibi bilgileri güncellenebilmekte veya silinebilmektedir.

## Projede Kullanılan Teknolojiler

- Java Spring Boot
- Maven
- Lombok
- MySql(Geliştirme yaparken bu databasei kullandım.)

## Pet Clinic Sistemindeki Modeller
- Owner
- Pet

Owner ve Pet olmak üzere 2 modelimiz bulunmaktadır. Sistemde ManyToOne ilişki bulunmaktadır. Böylelikle bir hayvan sahine birden fazla hayvan kaydı yapılabilir.Ancak bir hayvan yalnızca bir sahibi olabilir.
## Pet Clinic Sistemindeki Modeller Arasındaki İlişki
![Modeller Arası İlişki tablosu](https://i.hizliresim.com/ptscsw0.png)
