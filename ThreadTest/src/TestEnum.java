public enum TestEnum {  
  
    ADD ("+") {  
        @Override  
        public int calculate(int a, int b) {  
            return a + b;  
        }  
    },  
    SUBTRACT ("-") {  
        @Override  
        public int calculate(int a, int b) {  
            return a - b;  
        }  
    },  
    MULTIPLY  ("*") {  
        @Override  
        public int calculate(int a, int b) {  
            return a * b;  
        }  
    },  
    DIVIDE ("/") {  
        @Override  
        public int calculate(int a, int b) {  
            if (b == 0) {  
                throw new IllegalArgumentException("divisor must not be 0");  
            }  
            return a / b;  
        }  
    };  
  
    TestEnum (String operator) {  
        this.operator = operator;  
    }  
  
    private String operator;  
  
    public abstract int calculate(int a, int b);  
  
    public String getOperator() {  
        return operator;  
    }
    
}