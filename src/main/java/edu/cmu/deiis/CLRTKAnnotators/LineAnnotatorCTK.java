package edu.cmu.deiis.CLRTKAnnotators;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;

import edu.cmu.deiis.types.CTK.Answer;
import edu.cmu.deiis.types.CTK.Question;

public class LineAnnotatorCTK extends JCasAnnotator_ImplBase {

  @Override
  public void process(JCas aJCas) throws AnalysisEngineProcessException {
    // TODO Auto-generated method stub
    String docText = aJCas.getDocumentText();
    String lines[] = docText.split(System.getProperty("line.separator"));
    int Position = 0;
    for (int linein = 0; linein < lines.length; linein++) {
      if (linein == 0) {
        Question qa = new Question(aJCas);
        qa.setBegin(Position + 2);
        qa.setEnd(Position + lines[linein].length());
        Position += (lines[linein].length() + 1);
        qa.addToIndexes();
      } else {
        Answer aa = new Answer(aJCas);
        aa.setBegin(Position + 4);
        aa.setEnd(Position + lines[linein].length());
        Position += (lines[linein].length() + 1);
        if (lines[linein].charAt(2) == '1') {
          aa.setIsCorrect(true);
        } else {
          aa.setIsCorrect(false);
        }
        aa.addToIndexes();
      }
    }
  }

}
