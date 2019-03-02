package apeman_core.features_extraction.calculators.candidate;

import com.intellij.psi.PsiAssignmentExpression;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.research.groups.ml_methods.utils.ExtractionCandidate;

import java.util.ArrayList;

public class NumAssignmentsCandidateCalculator extends AbstractNumCandidateCalculator {

    public NumAssignmentsCandidateCalculator(ArrayList<ExtractionCandidate> candidates) {
        super(candidates);
    }

    @Override
    protected PsiElementVisitor createVisitor() {
        return new NumAssignmentsCandidateCalculator.Visitor();
    }

    private class Visitor extends CandidateVisitor {

        @Override
        public void visitAssignmentExpression(PsiAssignmentExpression expression) {
            super.visitAssignmentExpression(expression);

            if (isInsideMethod) {
                updateCounters();
            }
        }
    }
}