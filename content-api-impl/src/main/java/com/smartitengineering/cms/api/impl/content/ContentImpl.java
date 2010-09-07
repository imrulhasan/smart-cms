/*
 *
 * This is a simple Content Management System (CMS)
 * Copyright (C) 2009  Imran M Yousuf (imyousuf@smartitengineering.com)
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.smartitengineering.cms.api.impl.content;

import com.smartitengineering.cms.api.WorkspaceId;
import com.smartitengineering.cms.api.content.Content;
import com.smartitengineering.cms.api.content.ContentId;
import com.smartitengineering.cms.api.content.Field;
import com.smartitengineering.cms.api.content.MutableContent;
import com.smartitengineering.cms.api.content.Representation;
import com.smartitengineering.cms.api.impl.AbstractPersistableDomain;
import com.smartitengineering.cms.api.type.ContentStatus;
import com.smartitengineering.cms.api.type.ContentType;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author kaisar
 */
public class ContentImpl extends AbstractPersistableDomain<MutableContent> implements MutableContent {

  private ContentId contentId;
  private ContentId parentId;
  private Content parentContent;
  private ContentType contentDef;
  private ContentStatus contentStatus;
  private Date creationDate;
  private Date lastModifiedDate;
  private Map<String, Field> map = new HashMap<String, Field>();
  private Map<String, Representation> representations = new HashMap<String, Representation>();

  public ContentImpl() {
    super(MutableContent.class);
  }

  @Override
  public void setParentId(ContentId contentId) {
    this.parentId = contentId;
  }

  @Override
  public void setContentDefinition(ContentType contentType) {
    this.contentDef = contentType;
  }

  @Override
  public void setField(Field field) {
    map.put(field.getName(), field);
  }

  @Override
  public void setStatus(ContentStatus contentStatus) {
    this.contentStatus = contentStatus;
  }

  @Override
  public ContentId getContentId() {
    return this.contentId;
  }

  @Override
  public ContentId getParentId() {
    return this.parentId;
  }

  @Override
  public Content getParent() {
    return this.parentContent;
  }

  @Override
  public ContentType getContentDefinition() {
    return this.contentDef;
  }

  @Override
  public Map<String, Field> getFields() {
    return Collections.unmodifiableMap(this.map);
  }

  @Override
  public Field getField(String fieldName) {
    return map.get(fieldName);
  }

  @Override
  public ContentStatus getStatus() {
    return this.contentStatus;
  }

  @Override
  public Representation getRepresentation(String repName) {
    return representations.get(repName);
  }

  @Override
  public Date getCreationDate() {
    return this.creationDate;
  }

  @Override
  public Date getLastModifiedDate() {
    return this.lastModifiedDate;
  }

  @Override
  public boolean isPersisted() {
    return contentId != null;
  }

  @Override
  public String getKeyStringRep() {
    StringBuilder builder = new StringBuilder();
    if (isPersisted()) {
      WorkspaceId workspaceId = contentId.getWorkspaceId();
      builder.append(workspaceId.getGlobalNamespace()).append(':').append(workspaceId.getName()).append(':').
          append(new String(contentId.getId()));
    }
    return builder.toString();
  }

  @Override
  public void removeField(String fieldName) {
    map.remove(fieldName);
  }

  public Map<String, Representation> getRepresentations() {
    return representations;
  }
}