import java.util.Set;
import java.util.List;

class Constant {
    private String name;

    public Constant(String name) {
        this.name = name();
    }

    public String name() {
        return name;
    }

    public String eval(Structure m) {
        return m.iC(name());
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object other) {
        if (getClass() != other.getClass()) return false;
        Constant otherC = (Constant) other;
        return name() == otherC.name();
    }
}

class Formula {
    private Formula formula;

    public List<Formula> subfs() {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public String toString() {
        return "" + formula;
    }

    public boolean isTrue(Structure m) {
        return true;
    }

    @Override
    public boolean equals(Object other) {
        if (getClass() != other.getClass()) return false;
        Formula otherF = (Formula) other;
        return formula == otherF;
    }

    public int deg() {
        return 1;
    }

    public Set<AtomicFormula> atoms() {
        throw new RuntimeException("Not implemented");
    }

    public Set<String> constants() {
        throw new RuntimeException("Not implemented");
    }

    public Set<String> predicates() {
        throw new RuntimeException("Not implemented");
    }
}

class AtomicFormula extends Formula {
    AtomicFormula() {
    }
}

class PredicateAtom extends AtomicFormula {
    PredicateAtom(String name, List<Constant> args) {
        name = super(name);
        args = super(args);
    }

    String name() {
        return name;
    }

    List<Constant> arguments() {
        return args;
    }
}

class EqualityAtom extends AtomicFormula {
    EqualityAtom(Constant left, Constant right) {
        Constant l = super(left);
        Constant r = super(right);
    }

    Constant left() {
        return l;
    }

    Constant right() {
        return l;
    }
}

class Negation extends Formula {
    Negation(Formula originalFormula) {
        originalFormula = super(originalFormula);
    }

    public Formula originalFormula() {
        return originalFormula;
    }
}

class Disjunction extends Formula {
    Disjunction(List<Formula> disjuncts) {
        super(disjuncts);
    }
}

class Conjunction extends Formula {
    Conjunction(List<Formula> disjuncts) {
        super(disjuncts);
    }
}

class BinaryFormula extends Formula {
    BinaryFormula(Formula left, Formula right) {
        Formula l = super(left);
        Formula r = super(right);
    }

    public Formula leftSide() {
        return l;
    }

    public Formula rightSide() {
        return r;
    }
}

class Implication extends BinaryFormula {
    Implication(Formula left, Formula right) {
        super(left, right);
    }
}

class Equivalence extends BinaryFormula {
    Equivalence(Formula left, Formula right) {
        super(left, right);
    }
}
