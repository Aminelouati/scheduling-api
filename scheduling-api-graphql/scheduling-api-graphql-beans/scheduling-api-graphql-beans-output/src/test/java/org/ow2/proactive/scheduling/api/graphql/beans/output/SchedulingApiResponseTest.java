/*
 * ProActive Parallel Suite(TM):
 * The Open Source library for parallel and distributed
 * Workflows & Scheduling, Orchestration, Cloud Automation
 * and Big Data Analysis on Enterprise Grids & Clouds.
 *
 * Copyright (c) 2007 - 2017 ActiveEon
 * Contact: contact@activeeon.com
 *
 * This library is free software: you can redistribute it and/or
 * modify it under the terms of the GNU Affero General Public License
 * as published by the Free Software Foundation: version 3 of
 * the License.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 *
 * If needed, contact us to obtain a release under GPL Version 2 or 3
 * or a different license than the AGPL.
 */
package org.ow2.proactive.scheduling.api.graphql.beans.output;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.net.URL;

import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.io.Resources;


public class SchedulingApiResponseTest {

    @Test
    public void testSchedulingApiResponse() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        URL url = Resources.getResource("jobs.json");
        File file = new File(url.toURI());
        SchedulingApiResponse response = mapper.readValue(file, SchedulingApiResponse.class);
        assertThat(response.getData().getViewer().getJobs().getEdges(), is(notNullValue()));
        assertThat(response.getData().getViewer().getJobs().getPageInfo(), is(notNullValue()));
        assertThat(response.getData().getViewer().getJobs().getEdges().size(), is(4));
        JobNode job = response.getData().getViewer().getJobs().getEdges().get(0).getJobNode();
        assertThat(job, is(notNullValue()));
        assertThat(job.getId(), is(1L));
    }

}
