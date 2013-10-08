package edu.cmu.deiis.CLRTKAnnotators;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.FSIndex;
import org.apache.uima.jcas.JCas;
import org.cleartk.ne.type.NamedEntityMention;

import edu.cmu.deiis.types.CTK.Answer;
import edu.cmu.deiis.types.CTK.Question;
import edu.cmu.deiis.types.CTK.Token;

public class CTKQuestionAnswerAnnotator extends JCasAnnotator_ImplBase {

  @Override
  public void process(JCas aJCas) throws AnalysisEngineProcessException {
    // TODO Auto-generated method stub
    FSIndex neIndex = aJCas.getAnnotationIndex(org.cleartk.ne.type.NamedEntityMention.type);
    Iterator neIter = neIndex.iterator();
    NamedEntityMention ne = null;

    FSIndex qIndex = aJCas.getAnnotationIndex(Question.type);
    Iterator qIter = qIndex.iterator();
    Question qa = (Question) qIter.next();
    List<String> qarr = new ArrayList<String>();
    boolean flag = true;
    while (neIter.hasNext() && flag) {
      ne = (NamedEntityMention) neIter.next();
      if (ne.getEnd() <= qa.getEnd()) { // span checking
        qarr.add(ne.getCoveredText());
      } else
        flag = false;
    }

    flag = true;
    FSIndex aIndex = aJCas.getAnnotationIndex(Answer.type);
    Iterator aIter = aIndex.iterator();
    List<String> aarr = new ArrayList<String>();
    while (aIter.hasNext()) {
      Answer aa = (Answer) aIter.next();
      if (ne != null) {
        aarr.add(ne.getCoveredText());
      }
      while (neIter.hasNext() && flag) {
        ne = (NamedEntityMention) neIter.next();
        if (ne.getEnd() <= aa.getEnd()) {
          aarr.add(ne.getCoveredText());
        } else
          flag = false;

      }
    }
    double match = 0.0;
    int total = aarr.size();
    for (int i = 0; i < qarr.size(); i++) {
      for (int j = 0; j < aarr.size(); j++) {
        if (qarr.get(i).equals(aarr.get(j))) {
          match++;
          aarr.remove(i);
        }
      }
    }
    double accuracy = match/total;
    System.out.println("Accuracy : " + accuracy);
    

  }
}
