
/* First created by JCasGen Mon Oct 07 20:19:59 PDT 2013 */
package edu.cmu.deiis.types.CTK;

import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.cas.impl.CASImpl;
import org.apache.uima.cas.impl.FSGenerator;
import org.apache.uima.cas.FeatureStructure;
import org.apache.uima.cas.impl.TypeImpl;
import org.apache.uima.cas.Type;
import org.apache.uima.cas.impl.FeatureImpl;
import org.apache.uima.cas.Feature;
import org.apache.uima.jcas.tcas.Annotation_Type;

/** 
 * Updated by JCasGen Mon Oct 07 20:19:59 PDT 2013
 * @generated */
public class Token_Type extends Annotation_Type {
  /** @generated */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (Token_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = Token_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new Token(addr, Token_Type.this);
  			   Token_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new Token(addr, Token_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = Token.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("edu.cmu.deiis.types.CTK.Token");
 
  /** @generated */
  final Feature casFeat_NE;
  /** @generated */
  final int     casFeatCode_NE;
  /** @generated */ 
  public String getNE(int addr) {
        if (featOkTst && casFeat_NE == null)
      jcas.throwFeatMissing("NE", "edu.cmu.deiis.types.CTK.Token");
    return ll_cas.ll_getStringValue(addr, casFeatCode_NE);
  }
  /** @generated */    
  public void setNE(int addr, String v) {
        if (featOkTst && casFeat_NE == null)
      jcas.throwFeatMissing("NE", "edu.cmu.deiis.types.CTK.Token");
    ll_cas.ll_setStringValue(addr, casFeatCode_NE, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public Token_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_NE = jcas.getRequiredFeatureDE(casType, "NE", "uima.cas.String", featOkTst);
    casFeatCode_NE  = (null == casFeat_NE) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_NE).getCode();

  }
}



    