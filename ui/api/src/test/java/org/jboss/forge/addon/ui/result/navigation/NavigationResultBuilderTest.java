/**
 * Copyright 2014 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.jboss.forge.addon.ui.result.navigation;

import org.jboss.forge.addon.ui.result.NavigationResult;
import org.jboss.forge.addon.ui.result.navigation.NavigationResultBuilder;
import org.jboss.forge.addon.ui.util.MockCommand;
import org.jboss.forge.addon.ui.util.MockCommand2;
import org.jboss.forge.addon.ui.util.MockCommand3;
import org.junit.Assert;
import org.junit.Test;

/**
 * Tests for {@link NavigationResultBuilder}
 * 
 * @author <a href="ggastald@redhat.com">George Gastaldi</a>
 */
public class NavigationResultBuilderTest
{
   @Test
   public void testBuilderBuildShouldBeNullForNoEntries()
   {
      NavigationResultBuilder builder = NavigationResultBuilder.create();
      NavigationResult result = builder.build();
      Assert.assertNull(result);
   }

   @Test
   public void testBuilderEntriesSizeMatch()
   {
      NavigationResultBuilder builder = NavigationResultBuilder.create();
      builder.add(MockCommand.class).add(MockCommand2.class).add(MockCommand3.class).add(new MockCommand());
      NavigationResult result = builder.build();
      Assert.assertNotNull(result);
      Assert.assertNotNull(result.getNext());
      Assert.assertEquals(4, result.getNext().length);
   }
}