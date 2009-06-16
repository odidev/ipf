/*
 * Copyright 2009 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.openehealth.ipf.modules.cda.builder

import org.openehealth.ipf.modules.cda.builder.CDAR2ModelExtension
import org.openehealth.ipf.modules.cda.CDAR2Renderer
import org.eclipse.emf.ecore.xmi.XMLResource
import org.openhealthtools.ihe.common.cdar2.*
import org.openhealthtools.ihe.common.cdar2.impl.*

/**
 * @author Stefan Ivanov
 */
public class CDAR2BuilderStructureRegionOfInterestTest extends AbstractCDAR2BuilderTest {
	
	
	/**
	 * Test simple RegionOfInterest
	 */
	public void testRegionOfInterest() {
		def entry = builder.build {
			entry{
			    regionOfInterest(classCode:'ROIOVL', moodCode:'EVN'){//, iD1:'MM1'){
			        id(root:'2.16.840.1.113883.19.3.1')
			        code(code:'ELLIPSE')
//			        value(value:'3', unsorted:'true')
			        value(value:'1')
                    value(value:'3')
                    value(value:'7')
                    entryRelationship(typeCode:'SUBJ'){
			            observationMedia(classCode:'OBS', moodCode:'EVN'){
			                id(root:'2.16.840.1.113883.19.2.1')
			                value(mediaType:'image/gif'){
			                    reference(value:'lefthand.gif')
			                }//value
			            }//observation media
			        }//entry relationship
			    }//region of interest
			}//entry
		}
		// println entry.regionOfInterest
	}
	
	/**
	 * Test regionOfInterest defaults
	 */
	public void testRegionOfInteresttDefaultValues() {
		def entry = builder.build {
			entry{
			    regionOfInterest(classCode:'ROIOVL', moodCode:'EVN'){
			        id()
			        code()
                  value(value:'3')
			    }
			}//entry
		}
		// println entry.regionOfInterest
	}
	
   /**
	* Test regionOfInterest constraints
    */
   public void testRegionOfInterestConstraints() {
       shouldFail{//mising id
          builder.build{
              regionOfInterest(classCode:'ROIOVL', moodCode:'EVN'){
                  code()
                  value(value:'3')
              }
          }
       }

       shouldFail{//mising code
           builder.build{
               regionOfInterest(classCode:'ROIOVL', moodCode:'EVN'){
                   id()
                   value(value:'3')
               }
           }
        }
       
       shouldFail{//mising value
           builder.build{
               regionOfInterest(classCode:'ROIOVL', moodCode:'EVN'){
                   id()
                   code()
               }
           }
        }
    }
       
}