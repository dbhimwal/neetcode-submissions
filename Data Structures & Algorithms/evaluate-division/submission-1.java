class Solution {
    class SolvedEquation {
        List<String> equation;
        double value;

        SolvedEquation(List<String> eq, double result) {
            equation = eq;
            value = result;
        }
    }

    private static double DEFAULT_ANSWER = -1;

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, List<SolvedEquation>> variableDetails = new HashMap<>();

        for(int i = 0; i < equations.size(); i++) {
            List<String> eq = equations.get(i);
            double result = values[i];
            SolvedEquation seq = new SolvedEquation(eq, result);
            if(variableDetails.containsKey(eq.get(0))) {
                variableDetails.get(eq.get(0)).add(seq);
            } else {
                List<SolvedEquation> variableEquations = new ArrayList<>();
                variableEquations.add(seq);
                variableDetails.put(eq.get(0), variableEquations);
            }
            if(variableDetails.containsKey(eq.get(1))) {
                variableDetails.get(eq.get(1)).add(seq);
            } else {
                List<SolvedEquation> variableEquations = new ArrayList<>();
                variableEquations.add(seq);
                variableDetails.put(eq.get(1), variableEquations);
            }
        }

        double[] response = new double[queries.size()];

        for(int i = 0; i < queries.size(); i++) {
            response[i] = solve(queries.get(i), variableDetails);
        }

        return response;
    }

    private double solve(List<String> query, Map<String, List<SolvedEquation>> variableDetails) {
        // System.out.println(query);
        double defaultResult = -1;
        if(!variableDetails.containsKey(query.get(0)) || !variableDetails.containsKey(query.get(1))) {
            return defaultResult;
        }
        double result = 1;
        for(SolvedEquation seq : variableDetails.get(query.get(0))) {
            String startingVariable;
            Set<String> seen = new HashSet<>();
            if(seq.equation.get(0).equals(query.get(0))) {
                result = seq.value;
                startingVariable = seq.equation.get(1);
            } else {
                result = result/seq.value;
                startingVariable = seq.equation.get(0);
            }
            double calculation = dfs(startingVariable, query.get(1), variableDetails, result, seen);
            if(calculation != defaultResult) {
                return calculation;
            }
        }

        return defaultResult;
    }

    private double dfs(String source, String target, Map<String, List<SolvedEquation>> variableDetails, double calculation, Set<String> visited) {
        if(source.equals(target)) {
            return calculation;
        }

        if(visited.contains(source)) {
            return -1;
        }

        visited.add(source);

        for(SolvedEquation seq : variableDetails.get(source)) {
            String variable;
            double value;
            if(seq.equation.get(0).equals(source)) {
                value = seq.value;
                variable = seq.equation.get(1);
            } else {
                value = 1/seq.value;
                variable = seq.equation.get(0);
            }
            double result = dfs(variable, target, variableDetails, calculation * value, visited);
            if(result != DEFAULT_ANSWER) {
                return result;
            }
        }

        visited.remove(source);

        return -1;
    }
}