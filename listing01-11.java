///////////////////////////////////
// Listing 1: Switch Expressions //
///////////////////////////////////

jshell> import java.time.*
jshell> DayOfWeek day = DayOfWeek.FRIDAY
day ==> FRIDAY
jshell> int numOfLetters = switch (day)
   ...> {
   ...>     case MONDAY, FRIDAY, SUNDAY -> 6;
   ...>     case TUESDAY                -> 7;
   ...>     case THURSDAY, SATURDAY     -> 8;
   ...>     case WEDNESDAY              -> 9;
   ...> };
   ...> 
numOfLetters ==> 6


////////////////////////////////////
// Listing 2: Mehrzeilige Strings //
////////////////////////////////////

jshell> String multiLineString = """
   ...> This is line 1
   ...> Second line with "quotes"
   ...> Last line with 'single quotes'
   ...> """
multiLineString ==> "This is line 1\nSecond line with \"quotes\"\nLast line with 'single quotes'\n"


//////////////////////////////////////
// Listing 3: Strings spezifizieren //
//////////////////////////////////////

jshell> String multiLine2 = """
   ...> Zeile 1 
   ...> Zeile 2 BLA BLA BLA
   ...> Zeile 3 und Ende"""
multiLine2 ==> "Zeile 1\nZeile 2 BLA BLA BLA\nZeile 3 und Ende"
jshell> multiLine2.length()
$190 ==> 44

jshell> multiLine2.replace("BLA", "WICHTIG")
$191 ==> "Zeile 1\nZeile 2 WICHTIG WICHTIG WICHTIG\nZeile 3 und Ende"

jshell> String placeholders = """
   ...>        Michael %s hat am "%tF %d Bücher in '%s' gekauft.
   ...>        """.formatted("Inden", LocalDate.of(2020, 1, 20), 7, "Bremen");
placeholders ==> "Michael Inden hat am \"2020-01-20 7 Bücher in 'Bremen' gekauft.\n"


///////////////////////////////
// Listing 4: JSON einbinden //
///////////////////////////////

jshell> String jsonObj = """
   ...>                  {
   ...>                      "name": "Mike",
   ...>                      "birthday": "1971-02-07",
   ...>                      "comment": "Text blocks are nice!"
   ...>                  }
   ...>                  """;
   ...> 
jsonObj ==> "{\n    \"name\"    : \"Mike\",\n    \"birthday\" ... t blocks are nice!\"\n}\n"


/////////////////////////////////
// Listing 5: Pattern Matching //
/////////////////////////////////

Object obj = "Hallo Java 14";
if (obj instanceof String str) 
{
     System.out.println("Länge: " + str.length());
} 
else 
{
     System.out.println(obj.getClass());
}


//////////////////////////////////////////
// Listing 6: Beispiel für einen Record //
//////////////////////////////////////////

public final class MyPoint
{
    private final int x;
    private final int y;
    public MyPoint(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
    @Override 
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;   
        MyPoint point = (MyPoint) o;
        return x == point.x && y == point.y;
    }
    @Override 
    public int hashCode()
    {
        return Objects.hash(x, y);
    }
    @Override public String toString()
    {
        return "MyPoint[x=" + x + ", y=" + y + "]";
} }


////////////////////////////////////////////////
// Listing 7: Pattern Matching und instanceof //
////////////////////////////////////////////////

static String formatterJdk16instanceof(Object obj) {
    String formatted = "unknown";
    if (obj instanceof Integer i) {
        formatted = String.format("int %d", i);
    } else if (obj instanceof Long l) {
        formatted = String.format("long %d", l);
    } else if (obj instanceof Double d) {
        formatted = String.format("double %f", d);
    } else if (obj instanceof String s) {
        formatted = String.format("String %s", s);
    }
    return formatted;
}


//////////////////////////////////////////////////////////////
// Listing 8: Beispiel für instanceof ohne Pattern Matching //
//////////////////////////////////////////////////////////////

String formatted = "unknown";
if (obj instanceof Integer) {
    Integer i = (Integer) obj;
    formatted = String.format("int %d", i);
} else if (obj instanceof Long) {
    Long l = (Long) obj;
    formatted = String.format("long %d", l);
} 


/////////////////////////////////////
// Listing 9: Null-Werte behandeln //
/////////////////////////////////////

jshell> static void switchSupportingNull(String str) 
   ...> {       
   ...>     switch (str) 
   ...>     {   
   ...>         case null -> System.out.println("null is now allowed");
   ...>         case "Java", "Python" -> System.out.println("cool");
   ...>         default -> System.out.println("everything else");
   ...>     }
   ...> }
|  created method switchSupportingNull(String)

jshell> switchSupportingNull(null)
null is now allowed

jshell> switchSupportingNull("Python")
cool language


/////////////////////////////////////
// Listing 10: Komplexere Abfragen //
/////////////////////////////////////

static void processData(Object obj) {
    switch (obj) {
        case String str && str.startsWith("V1") -> 
             System.out.println("Processing V1");
        case String str && str.startsWith("V2") -> 
             System.out.println("Processing V2");
        case Integer i && i > 10 && i < 100 -> 
             System.out.println("Processing ints");
        default -> throw new IllegalArgumentException("invalid input"); 
    }


/////////////////////////////////////////////////////////
// Listing 11: Aufrufe der Preview-Neuerung bei switch //
/////////////////////////////////////////////////////////

jshell> processData("V1 Data")
Processing V1
jshell> processData("V2 Data")
Processing V2
jshell> processData(42)
Processing ints
jshell> processData(7271)
|  Exception java.lang.IllegalArgumentException: invalid input
|        at processData (#8:6)
|        at (#12:1)

