/*
 * IdeaVim - Vim emulator for IDEs based on the IntelliJ platform
 * Copyright (C) 2003-2022 The IdeaVim authors
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <https://www.gnu.org/licenses/>.
 */

package com.maddyhome.idea.vim.vimscript.model.commands

import com.intellij.openapi.actionSystem.DataContext
import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.editor.Editor
import com.maddyhome.idea.vim.api.injector
import com.maddyhome.idea.vim.ex.ranges.Ranges
import com.maddyhome.idea.vim.newapi.vim
import com.maddyhome.idea.vim.vimscript.model.ExecutionResult

/**
 * see "h :symbol"
 */
data class FindSymbolCommand(val ranges: Ranges, val argument: String) : Command.SingleExecution(ranges, argument) {
  override val argFlags = flags(RangeFlag.RANGE_FORBIDDEN, ArgumentFlag.ARGUMENT_OPTIONAL, Access.READ_ONLY)
  override fun processCommand(editor: Editor, context: DataContext): ExecutionResult {
    // TODO: Check the command argument and jump to a specific symbol
    ApplicationManager.getApplication().invokeLater { injector.actionExecutor.executeAction("GotoSymbol", context.vim) }
    return ExecutionResult.Success
  }
}
