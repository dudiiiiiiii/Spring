Linki do artykułów (10.04.22):
<ul>
<li>https://www.baeldung.com/spring-thymeleaf-fragments</li>
<li>https://www.baeldung.com/spring-requestparam-vs-pathvariable</li>
</ul>
Linki do artykułów (23.04.22):
<ul>
<li>https://www.baeldung.com/thymeleaf-iteration</li>
<li>https://www.baeldung.com/dates-in-thymeleaf</li>
</ul>
Zadanie 1:
<ul>
<li>Na wzór zakładki blog - utwórz zakładkę "produkty"</li>
<li>Kod będzie znajdował się w ProductController (url to "/products")</li>
<li>Utwórz klasę Product z polami (id, nazwa, opis, cena, utworzono, zaktualizowano (daty))</li>
<li>Na wzór zakładki blog - wypełnij listę produktów przykładowymi danymi</li>
<li>Zakładka "produkty" powinna być osiągalna z menu głównego - pokazywać listę produktów z "bazy"</li>
<li>Na zwór parametru "m" dla blog - utwórz możliwość filtrowania po cenie (parametr "p")</li>
<li>*cena +/- 20%</li>
</ul>
Zadanie 2:
<ul>
<li>Zmodyfikować zadanie 1 aby filtrować po cenie od-do (parametr "pf" i "pt")</li>
<li>Wyszukiwanie po nazwie (parametr "n"). Funkcja contains na stringu</li>
<li>Utworzyć enum z kategorią produktu (telefony, laptopy, tv, monitory)</li>
<li>Dodać do klasy Produkt pole z enumem z kategorią produktu i umożliwić wyszukiwanie po parametrze "c" np. c=phones</li>
</ul>
Zadanie 3:
<ul>
<li>Na wzór formularza w zakładce blog dodać formularz filtrujący w zakładce produkty</li>
<li>Fitrujemy po "pf" i "pt" (input number) oraz "n" i "c" (input text)</li>
<li>*parametr "c" powinien działać jako select z listą rozwijaną renderowaną z enuma</li>
</ul>
Zadanie 4:
<ul>
<li>Na zwór formularza dodawania produktu utworzyć formularz dodawania artykułu (blog)</li>
<li>Formularz wysyłamy metodą POST na @PostMapping - odbieramy dane jako Article</li>
<li>Dodajemy do listy articles i przekierujemy na zakładkę blog</li>
</ul>
Linki do artykułów (24.04.22):
<ul>
<li>https://www.baeldung.com/thymeleaf-select-option</li>
</ul>
Zadanie 5:
<ul>
<li>Utworzyć enum ArticleCategory (TECHNICAL, GUIDE, OTHER)</li>
<li>Do klasy Article dodać pole category o typie ArticleCategory</li>
<li>Wygenerować od nowa gettery i settery, kontruktor dla Article (nalezy uzupełnić listę w ArticleController o nowe pole)</li>
<li>Do zakładki blog dodać możliwość filtrowania po kategorii (enum ArticleCategory, na wzór kategorii w produktach)</li>
<li>Do formularza dodawania nowego artykułu dodać możliwość wybrania kategorii z listy (wzór produkty)</li>
<li>Formularz dodawania nowego artykułu zapisuje się wraz z kategorią</li>
</ul>
Zadanie 6:
<ul>
<li>Wyświelić na liście artykuów - kategorię artykułu</li>
<li>Wyświelić na liście produktów - kategorię produktów</li>
<li>Do produktu dodać pole obrazek (String image z adresem url do obrazka znalezionego w google)</li>
<li>Wyświetlić obrazek w zakładce products (th:src)</li>
</ul>
Zadanie domowe (na 07.05.22):
<ul>
<li>Utworzyć enum ServiceCategory (REPAIR, ADVICE)</li>
<li>Utworzyć klasę Service (pola: id, name, content, price, category (typ ServiceCategory), createdAt, updatedAt) na wzór Product</li>
<li>Wygenerować getery i setery, konsruktor do klasy Service</li>
<li>Utworzyć formularz pozwalający na dodanie usługi (pola: name, content, price, category)</li>
<li>Utworzyć ServiceController będący kontrolerem umożliwiającym pokazanie listy usług oraz formularza dodawania usługi (/services i /add-service)</li>
<li>Dodać w nawigacji możliwość uruchomienia strony "/services" i "/add-service"</li>
<li>W ServiceController istnieje lista usług wypełniona na wzór ProductController</li>
<li>Na widoku listy usług dodajemy możliwość filtrowania po kategorii oraz wyszukiwania po nazwie usługi</li>
<li>Istnieje możliwość wysłania formularza "dodawania nowej usługi" - po dodaniu do listy redirect na listę usług</li>
</ul>
