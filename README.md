# PSP
Testai buvo ganėtinai aiškūs, tik ne visi reikalingi/tikslūs. 
Pavyzdžiui, testas slaptažodžio ilgio validacijai yra sukurtas taip, jog implementacijoje funkcija turi grąžinti slaptažodžio ilgį,
ir jį palygina pačiame Unit Teste su ten nurodoma reikšme. Slaptažodžio ilgio tikrinimas turėtų vykti pačio validatoriaus viduje.
Implementacija praėjau per visus gautus Unit Testus.
Taip pat pridėjau ViltesTests.java failą su trimis naujais testais: 2 testus telefono numerio validacijai ir testą slaptažodžio ilgio validacijai.
Šie nauji testai yra korektiškesni ir iš tiesų patikrina mano parašytus validatorius.
