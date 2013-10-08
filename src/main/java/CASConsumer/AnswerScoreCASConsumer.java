package CASConsumer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.uima.cas.CAS;
import org.apache.uima.cas.CASException;
import org.apache.uima.cas.FSIndex;
import org.apache.uima.collection.CasConsumer_ImplBase;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceProcessException;
import org.apache.uima.util.ProcessTrace;

import edu.cmu.deiis.types.Answer;

public class AnswerScoreCASConsumer extends CasConsumer_ImplBase {
  int accuracy=0 ;
  @Override
  public void processCas(CAS aCAS) throws ResourceProcessException {
    // TODO Auto-generated method stub
    JCas aJCas = null;
    
    try {
      aJCas = aCAS.getJCas();
    } catch (CASException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    String docText = aJCas.getDocumentText();
    String lines[] = docText.split(System.getProperty("line.separator"));
    double max = 0.0;
    edu.cmu.deiis.types.Answer aa = new edu.cmu.deiis.types.Answer(aJCas);
    FSIndex AIndex = aJCas.getAnnotationIndex(edu.cmu.deiis.types.Answer.type);
    Iterator AIter = AIndex.iterator();
    ArrayList<edu.cmu.deiis.types.Answer> al = new ArrayList<edu.cmu.deiis.types.Answer>();
    for(int i=0;i<AIndex.size();i++){
      FSIndex AIndex1 = aJCas.getAnnotationIndex(edu.cmu.deiis.types.Answer.type);
      Iterator AIter1 = AIndex1.iterator();
    while (AIter1.hasNext()) {
      edu.cmu.deiis.types.Answer aa1 = (edu.cmu.deiis.types.Answer) AIter1.next();
      if(aa1.getScore()>max && aa1.getDummy()!=-1)
      {
         aa = aa1;
         max = aa1.getScore();
      }
    }
    al.add(aa);
    aa.setDummy(-1);
    aa = new edu.cmu.deiis.types.Answer(aJCas);
    max = 0.0;
    }
    //Collections.sort(al,Collections.reverseOrder(new AnswerComparator()));
    /*To print output*/
    /*int correct = 0;
    for (int i = 0; i < al.size(); i++) {
      String[] arr = lines[al.get(i).getAnswerOldPosition()].split(" ", 3);
      if (al.get(i).getIsCorrect()) {
        System.out.println("+ " + al.get(i).getScore() + " " + arr[2]);
        if (arr[1].equals("1"))
          correct++;
      } else {
        System.out.println("- " + al.get(i).getScore() + " " + arr[2]);
        if (arr[1].equals("0"))
          correct++;
      }
    }
    accuracy = correct/(lines.length-1);
    System.out.println("Accuracy at : "+accuracy); */
    
  }
}
