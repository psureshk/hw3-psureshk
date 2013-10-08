

/* First created by JCasGen Mon Oct 07 20:19:59 PDT 2013 */
package edu.cmu.deiis.types.CTK;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.Annotation;


/** 
 * Updated by JCasGen Mon Oct 07 20:19:59 PDT 2013
 * XML source: /home/psureshk/workspace/hw3-psureshk/src/main/resources/descriptors/deiis_typesCTK.xml
 * @generated */
public class Token extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(Token.class);
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int type = typeIndexID;
  /** @generated  */
  @Override
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   * @generated */
  protected Token() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public Token(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public Token(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public Token(JCas jcas, int begin, int end) {
    super(jcas);
    setBegin(begin);
    setEnd(end);
    readObject();
  }   

  /** <!-- begin-user-doc -->
    * Write your own initialization here
    * <!-- end-user-doc -->
  @generated modifiable */
  private void readObject() {/*default - does nothing empty block */}
     
 
    
  //*--------------*
  //* Feature: NE

  /** getter for NE - gets 
   * @generated */
  public String getNE() {
    if (Token_Type.featOkTst && ((Token_Type)jcasType).casFeat_NE == null)
      jcasType.jcas.throwFeatMissing("NE", "edu.cmu.deiis.types.CTK.Token");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Token_Type)jcasType).casFeatCode_NE);}
    
  /** setter for NE - sets  
   * @generated */
  public void setNE(String v) {
    if (Token_Type.featOkTst && ((Token_Type)jcasType).casFeat_NE == null)
      jcasType.jcas.throwFeatMissing("NE", "edu.cmu.deiis.types.CTK.Token");
    jcasType.ll_cas.ll_setStringValue(addr, ((Token_Type)jcasType).casFeatCode_NE, v);}    
  }

    