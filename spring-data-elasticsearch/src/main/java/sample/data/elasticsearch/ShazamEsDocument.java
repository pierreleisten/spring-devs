/*
 * Copyright 2012-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package sample.data.elasticsearch;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldIndex;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "shazam", type = "document", refreshInterval = "-1")
public class ShazamEsDocument {

	@Id
	private String id;

	@Field(type = FieldType.String, index = FieldIndex.no, store = true)
	private String title;

	@Field(type = FieldType.String, index = FieldIndex.not_analyzed, store = true)
	private List<String> signature;

	public ShazamEsDocument() {
	}

	/**
	 * @param id
	 * @param title
	 * @param signature
	 */
	public ShazamEsDocument(String id, String title, List<String> signature) {
		super();
		this.id = id;
		this.title = title;
		this.signature = signature;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the signature
	 */
	public List<String> getSignature() {
		return signature;
	}

	/**
	 * @param signature
	 *            the signature to set
	 */
	public void setSignature(List<String> signature) {
		this.signature = signature;
	}

	@Override
	public String toString() {
		return getId() + " - " + getSignature();
	}

}
