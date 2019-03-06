
public class Token {
    private Sym sym;
    private Object value;
    private Integer lineno;
    private Integer coleno;

    public Token(Sym sym, Object value, int lineno, int coleno) {
        this.sym = sym;
        this.value = value;
        this.lineno = lineno;
        this.coleno = coleno;
    }

    @Override
    public String toString() {
        return "Token: " + sym.toString() + " - value : " + value + " - lineno : " + lineno + " - coleno : " + coleno;
    }
}
